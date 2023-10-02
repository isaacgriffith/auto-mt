package dev.siliconcode.auto_mt.app.testreq.isp.clustering

import tech.tablesaw.api.DoubleColumn

/**
 * The Jenks optimization method, also called the Jenks natural breaks
 * classification method, is a data classification method designed to determine
 * the best arrangement of values into different classes. This is done by
 * seeking to minimize each class’s average deviation from the class mean, while
 * maximizing each class’s deviation from the means of the other groups. In
 * other words, the method seeks to reduce the variance within classes and
 * maximize the variance between classes.
 *
 * @version 1.0.0
 */
class Jenks {

    DoubleColumn column

    Jenks(DoubleColumn column) {
        this.column = column
    }

    /**
     * @return
     */
    Breaks computeBreaks() {
        this.column.sortAscending()

        int uniqueValues = this.column.countUnique()
        if (uniqueValues <= 3) {
            return computeBreaks(uniqueValues, this.column)
        }

        Breaks lastBreaks = computeBreaks(2, this.column)
        double lastGvf = lastBreaks.gvf()
        double lastImprovement = lastGvf - computeBreaks(1, this.column).gvf()

        for (int i = 3; i <= Math.min(6, uniqueValues); ++i) {
            Breaks breaks = computeBreaks(2, this.column)
            double gvf = breaks.gvf()
            double marginalImprovement = gvf - lastGvf
            if (marginalImprovement < lastImprovement) {
                return lastBreaks
            }
            lastBreaks = breaks
            lastGvf = gvf
            lastImprovement = marginalImprovement
        }

        return lastBreaks
    }

    /**
     * @param column     sorted column of values
     * @param numclass int number of classes
     * @return int[] breaks (upper indices of class)
     */
    Breaks computeBreaks(int numclass, DoubleColumn column, transform = new Identity()) {
        int numdata = column.size()

        if (numdata == 0) {
            return new Breaks(new double[0], new int[0])
        }

        double[][] mat1 = new double[numdata + 1][numclass + 1]
        double[][] mat2 = new double[numdata + 1][numclass + 1]

        for (int i = 1; i <= numclass; i++) {
            mat1[1][i] = 1
            mat2[1][i] = 0
            for (int j = 2; j <= numdata; j++) {
                mat2[j][i] = Double.MAX_VALUE
            }
        }
        double v = 0
        for (int l = 2; l <= numdata; l++) {
            double s1 = 0
            double s2 = 0
            double w = 0
            for (int m = 1; m <= l; m++) {
                int i3 = l - m + 1

                double val = transform.apply(column[i3 - 1])

                s2 += val * val
                s1 += val

                w++
                v = s2 - (s1 * s1) / w
                int i4 = i3 - 1
                if (i4 != 0) {
                    for (int j = 2; j <= numclass; j++) {
                        if (mat2[l][j] >= (v + mat2[i4][j - 1])) {
                            mat1[l][j] = i3
                            mat2[l][j] = v + mat2[i4][j - 1]
                        }
                    }
                }
            }
            mat1[l][1] = 1
            mat2[l][1] = v
        }
        int k = numdata

        int[] kclass = new int[numclass]

        kclass[numclass - 1] = column.size() - 1

        for (int j = numclass; j >= 2; j--) {
            int id = (int) (mat1[k][j]) - 2

            kclass[j - 2] = id

            k = (int) mat1[k][j] - 1
        }
        return new Breaks(column, kclass)
    }

    private interface DoubleFunction {
        double apply(double x)
    }

    private static class Log10 implements DoubleFunction {

        @Override
        double apply(double x) {
            return Math.log10(x)
        }
    }

    private static class Identity implements DoubleFunction {

        @Override
        double apply(double x) {
            return x
        }

    }

    static class Breaks {

        private double[] sortedValues
        private int[] breaks

        /**
         * @param sortedValues the complete array of sorted data values
         * @param breaks       the indexes of the values within the sorted array that begin new classes
         */
        private Breaks(DoubleColumn column, int[] breaks) {
            this.sortedValues = column.asDoubleArray()
            this.breaks = breaks
        }

        /**
         * The Goodness of Variance Fit (GVF) is found by taking the difference
         * between the squared deviations from the array mean (SDAM) and the
         * squared deviations from the class means (SDCM), and dividing by the
         * SDAM
         *
         * @return
         */
        double gvf() {
            double sdam = sumOfSquareDeviations(sortedValues)
            double sdcm = 0.0
            for (int i = 0; i != numClassses(); ++i) {
                sdcm += sumOfSquareDeviations(classList(i))
            }
            return (sdam - sdcm) / sdam
        }

        private double sumOfSquareDeviations(double[] values) {
            double mean = mean(values)
            double sum = 0.0
            for (int i = 0; i != values.length; ++i) {
                double sqDev = Math.pow(values[i] - mean, 2)
                sum += sqDev
            }
            return sum
        }

        double[] getValues() {
            return sortedValues
        }

        private double[] classList(int i) {
            int classStart = (i == 0) ? 0 : breaks[i - 1] + 1
            int classEnd = breaks[i]
            double[] list = new double[classEnd - classStart + 1]
            for (int j = classStart; j <= classEnd; ++j) {
                list[j - classStart] = sortedValues[j]
            }
            return list
        }

        /**
         * @param classIndex
         * @return the minimum value (inclusive) of the given class
         */
        double getClassMin(int classIndex) {
            if (classIndex == 0) {
                return sortedValues[0]
            } else {
                return sortedValues[breaks[classIndex - 1] + 1]
            }
        }

        /**
         * @param classIndex
         * @return the maximum value (inclusive) of the given class
         */
        double getClassMax(int classIndex) {
            return sortedValues[breaks[classIndex]]
        }

        int getClassCount(int classIndex) {
            if (classIndex == 0) {
                return breaks[0] + 1
            } else {
                return breaks[classIndex] - breaks[classIndex - 1]
            }
        }

        private  double mean(double[] values) {
            double sum = 0
            for (int i = 0; i != values.length; ++i) {
                sum += values[i]
            }
            return sum / values.length
        }

        int numClassses() {
            return breaks.length
        }

        @Override
        String toString() {
            StringBuilder sb = new StringBuilder()
            for (int i = 0; i != numClassses(); ++i) {
                if (getClassMin(i) == getClassMax(i)) {
                    sb.append(getClassMin(i))
                } else {
                    sb.append(getClassMin(i)).append(" - ").append(getClassMax(i))
                }
                sb.append(" (" + getClassCount(i) + ")")
                sb.append(" = ").append(Arrays.toString(classList(i)))
                sb.append("\n")
            }
            return sb.toString()
        }

        String printClusters() {
            StringBuilder sb = new StringBuilder()
            for (int i = 0; i != numClassses(); ++i) {
                if (getClassMin(i) == getClassMax(i)) {
                    sb.append(getClassMin(i))
                } else {
                    sb.append(getClassMin(i)).append(" - ").append(getClassMax(i))
                }
                sb.append(" (" + getClassCount(i) + ")")
                // sb.append("\n")
            }
            return sb.toString()
        }

        int classOf(double value) {
            for (int i = 0; i != numClassses(); ++i) {
                if (value <= getClassMax(i)) {
                    return i
                }
            }
            return numClassses() - 1
        }
    }

    static void main(String[] args) {
        DoubleColumn column = DoubleColumn.create("test")
        column.append(5.1)
        column.append(4.9)
        column.append(4.7)
        column.append(4.6)
        column.append(5)
        column.append(5.4)
        column.append(4.6)
        column.append(5)
        column.append(4.4)
        column.append(4.9)
        column.append(5.4)
        column.append(4.8)
        column.append(4.8)
        column.append(4.3)
        column.append(5.8)
        column.append(5.7)
        column.append(5.4)
        column.append(5.1)
        column.append(5.7)
        column.append(5.1)
        column.append(5.4)
        column.append(5.1)
        column.append(4.6)
        column.append(5.1)
        column.append(4.8)
        column.append(5)
        column.append(5)
        column.append(5.2)
        column.append(5.2)
        column.append(4.7)
        column.append(4.8)
        column.append(5.4)
        column.append(5.2)
        column.append(5.5)
        column.append(4.9)
        column.append(5)
        column.append(5.5)
        column.append(4.9)
        column.append(4.4)
        column.append(5.1)
        column.append(5)
        column.append(4.5)
        column.append(4.4)
        column.append(5)
        column.append(5.1)
        column.append(4.8)
        column.append(5.1)
        column.append(4.6)
        column.append(5.3)
        column.append(5)
        column.append(7)
        column.append(6.4)
        column.append(6.9)
        column.append(5.5)
        column.append(6.5)
        column.append(5.7)
        column.append(6.3)
        column.append(4.9)
        column.append(6.6)
        column.append(5.2)
        column.append(5)
        column.append(5.9)
        column.append(6)
        column.append(6.1)
        column.append(5.6)
        column.append(6.7)
        column.append(5.6)
        column.append(5.8)
        column.append(6.2)
        column.append(5.6)
        column.append(5.9)
        column.append(6.1)
        column.append(6.3)
        column.append(6.1)
        column.append(6.4)
        column.append(6.6)
        column.append(6.8)
        column.append(6.7)
        column.append(6)
        column.append(5.7)
        column.append(5.5)
        column.append(5.5)
        column.append(5.8)
        column.append(6)
        column.append(5.4)
        column.append(6)
        column.append(6.7)
        column.append(6.3)
        column.append(5.6)
        column.append(5.5)
        column.append(5.5)
        column.append(6.1)
        column.append(5.8)
        column.append(5)
        column.append(5.6)
        column.append(5.7)
        column.append(5.7)
        column.append(6.2)
        column.append(5.1)
        column.append(5.7)
        column.append(6.3)
        column.append(5.8)
        column.append(7.1)
        column.append(6.3)
        column.append(6.5)
        column.append(7.6)
        column.append(4.9)
        column.append(7.3)
        column.append(6.7)
        column.append(7.2)
        column.append(6.5)
        column.append(6.4)
        column.append(6.8)
        column.append(5.7)
        column.append(5.8)
        column.append(6.4)
        column.append(6.5)
        column.append(7.7)
        column.append(7.7)
        column.append(6)
        column.append(6.9)
        column.append(5.6)
        column.append(7.7)
        column.append(6.3)
        column.append(6.7)
        column.append(7.2)
        column.append(6.2)
        column.append(6.1)
        column.append(6.4)
        column.append(7.2)
        column.append(7.4)
        column.append(7.9)
        column.append(6.4)
        column.append(6.3)
        column.append(6.1)
        column.append(7.7)
        column.append(6.3)
        column.append(6.4)
        column.append(6)
        column.append(6.9)
        column.append(6.7)
        column.append(6.9)
        column.append(5.8)
        column.append(6.8)
        column.append(6.7)
        column.append(6.7)
        column.append(6.3)
        column.append(6.5)
        column.append(6.2)
        column.append(5.9)


        Jenks jenks = new Jenks(column)
        Breaks breaks = jenks.computeBreaks()
        println("Num Classes: " + breaks.numClassses())
        println("Values: " + breaks.getClassCount(1))
        println("Class Min: " + breaks.getClassMin(1))
        println("Class Max: " + breaks.getClassMax(1))
        println(jenks.computeBreaks().printClusters())
    }
}
