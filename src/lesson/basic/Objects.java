package lesson.basic;

public class Objects {
    /**
     * Types in java
     * - primitive
     * - objects
     *
     * Primitives types are types that are not objects
     * Objects are customizable datatypes created from a blueprint
     *
     */
    public static void main(String[] args) {
        String ebuka = new String("Ebuka");
        String mercedesMake = "Mercedes";
        int number = 0;
        String s = "";



        Car mercedes = new Car(mercedesMake); // creating an object by calling new (Uses a qualified constructor)
        Car peugeot = new Car("peugeotMake");
        // checking that default color is black
        Methods.print("Mercedes color: " + mercedes.color);
        Methods.print("Peugeot color: " + peugeot.color);

        peugeot.paintCar("Blue");

        Methods.print("Mercedes color after painting peugeot: " + mercedes.color);
        Methods.print("Peugeot color after painting peugeot: " + peugeot.color);
    }

    public static class Car{
        String color =  "Black";
        String make;
        int productionYear = 0;

        Car(){
        }

        Car(String make){
            this.make = make;
        }

        void paintCar(String colortoPaint){
            this.color = colortoPaint;
        }
    }
}
