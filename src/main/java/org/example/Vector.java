package org.example;

public class Vector {
    private double values[];
   private  Vector(double[] values) {
       this.values = values;
   }

   public double length() {
       double sum= 0;
       for (int i = 0;i < values.length;i++){
           sum += values[i] * values[i];
       }
   return Math.sqrt(sum);
   }

   public  double scalarProduct(Vector vector) {
       double res = 0;

       for (int i =0;i < values.length;i++){
           res += values[i] * vector.values[i];
       }
   return res;
   }
   public double cos(Vector vector){
       return scalarProduct(vector) / (length() * vector.length());
   }
    public Vector add(Vector vector){
       double[] another = new double[values.length];

       for (int i = 0;i < vector.length();i++){
           another[i] = values[i] - vector.values[i];
       }
    return new Vector(another);
   }
   private static double[] generateRandomArray(int lenght){
       double[] array = new double[lenght];
       for (int i = 0; i < array.length;i++){
           array[i] = Math.random();
       }
       return array;

   }
   public static  Vector[] generate(int n, int dimension ){
       Vector[] vectors = new Vector[n];
       for(int i = 0;i < n;i++){
           vectors[i] = new Vector(generateRandomArray(dimension));
       }
   return vectors;
   }

    public static void main(String[] args) {
        Vector[] vectors = Vector.generate(10,55);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].length());
        System.out.println(vectors[0].scalarProduct(vectors[1]));
        System.out.println(vectors[0].cos(vectors[1]));
        System.out.println(vectors[0].add(vectors[1]));

    }
}