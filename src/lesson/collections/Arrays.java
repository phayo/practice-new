package lesson.collections;

import lesson.basic.Objects;

public class Arrays {
    /**
     *
     */

    public static void main(String[] args) {
        int[] integers = new int[]{1,2,3,4,5,6,7,8,9};
        String[] strings = new String[]{"qnother", "string"};
        Car[] cars = new Car[]{new Car("mercedesMake"), new Car("peugeotMake")};
        Car firstCar = cars[0];
        Car secondCar = cars[1];
        System.out.println("test");
        Car thirdCar = cars[2];

        int[] integers2 = new int[20];
        Car[] cars2 = new Car[15];
        integers2[0] = 6;
        Car audi = new Car("Audi");
        cars2[0] = audi;

        for(int i = 0; i < cars2.length; i++){
            Car c = cars2[i];
        }

        for(Car c: cars2){

        }
    }
}

class Car{
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