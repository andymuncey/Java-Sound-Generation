//package uk.ac.chester;
//
//public class Octave {
//
//    private double rootFreq;
//
//    public Octave(){
//        //C4
//        this(261.6256); //C4
//    }
//
//    public Octave(double startFreq){
//        rootFreq = startFreq;
//        double[] scale = new double[13];
//        scale[0] = rootFreq;
//        for (int i = 1; i <= 12; i++) {
//            scale[i] = semitoneUp(scale[i - 1]);
//        }
//        chromaticScale = scale;
//    }
//
//
//
//    //starts at C4
//    private double[] chromaticScale;// = {261.6256,277.1826,293.6648,311.1270,329.6276,349.2282,369.9944,391.9954,415.3047,440.0000,466.1638,493.8833};
//
//    static double semitoneUp(double freq) {
//        return freq * Math.pow(Math.E, Math.log(2)/12) ;
//    }
//
//    static double semitoneDown(double freq){
//        return freq / Math.pow(Math.E, Math.log(2)/12);
//    }
//
//     double[] chromatic() {
//        return chromaticScale;
//    }
//
//    double[] major(){
//        return scaleFromChromaticIndexes(new int[]{0,2,4,5,7,9,11,12});
//    }
//
//    double[] minor(){
//        return scaleFromChromaticIndexes(new int[]{0,2,3,5,7,8,11,12});
//    }
//
//    private double[] scaleFromChromaticIndexes(int[] indexes){
//        double[] scale = new double[indexes.length];
//        for (int i = 0; i < indexes.length; i++) {
//            scale[i] = chromaticScale[indexes[i]];
//        }
//        return scale;
//    }
//
//
//    double c(){
//        return chromaticScale[0];
//    }
//    double cSharp(){
//        return chromaticScale[1];
//    }
//    double dFlat(){
//        return cSharp();
//    }
//    double d(){
//        return chromaticScale[2];
//    }
//    double dSharp(){
//        return chromaticScale[3];
//    }
//    double eFlat(){
//        return dSharp();
//    }
//    double e(){
//        return chromaticScale[4];
//    }
//    double f(){
//        return chromaticScale[5];
//    }
//    double fSharp(){
//        return chromaticScale[6];
//    }
//    double gFlat(){
//        return fSharp();
//    }
//    double g(){
//        return chromaticScale[7];
//    }
//    double gSharp(){
//        return chromaticScale[8];
//    }
//    double aFlat(){
//        return gSharp();
//    }
//    double a(){
//        return chromaticScale[9];
//    }
//    double aSharp(){
//        return chromaticScale[10];
//    }
//    double bFlat() {
//        return aSharp();
//    }
//    double b(){
//        return chromaticScale[11];
//    }
//
//}
//
//
