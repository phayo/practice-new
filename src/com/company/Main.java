package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Integer[] arr = new Integer[]{2,1,-3,5,67,188,2,3,4,5,6,7,8,9,0,0,0,9,89,56,25,-23,9,-3,288,-9};
//        sort(arr, 0, arr.length -1);
//        System.out.println(Arrays.toString(arr));

        Movie[] movies = new Movie[]{new Movie("comedy"), new Movie("comedy,horror"), new Movie("horror,comedy,action"), new Movie(("action,horror"))};

        Map<String, List<MovieDTO>> map =  Arrays.stream(movies)
                .flatMap(Main::mapToStream)
                .collect(Collectors.groupingBy(MovieDTO::getGenre));



        final int highestGenre = map.values().stream()
                .map(List::size)
                .reduce(0, Math::max);



        if(highestGenre >= (movies.length / 2)){
            Set<String> genres = map.entrySet().stream()
                    .filter(entry -> highestGenre == entry.getValue().size()).map(Map.Entry::getKey).collect(Collectors.toSet());

            System.out.println("typecasted");
            System.out.println(genres);
        } else{
            System.out.println("Not typecasted");
        }


        //System.out.println(map);
    }

    static Stream<MovieDTO> mapToStream(Movie movie){
        return Arrays.stream(movie.genre.split(",")).map(MovieDTO::new);
    }

    static void merge(int[] Arr, int start, int mid, int end) {

        // create a temp array
        int[] temp = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1; i += 1;
            }
            else {
                temp[k] = Arr[j];
                k += 1; j += 1;
            }
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }

        // add elements left in the second interval
        while(j <= end) {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

    // Arr is an array of integer type
    // start and end are the starting and ending index of current interval of Arr

    static void sort(int[] Arr, int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            sort(Arr, start, mid);
            sort(Arr, mid+1, end);
            merge(Arr, start, mid, end);
        }
    }

    static class Movie{
        public Movie(String genre){this.genre = genre;}
        String genre;
    }

    static class MovieDTO{
        public MovieDTO(String genre){this.genre = genre;}
        private String genre;
        public String getGenre(){return  this.genre;}

        @Override
        public String toString() {
            return "MovieDTO{" +
                    "genre='" + genre + '\'' +
                    '}';
        }
    }

}

//"""
//{
//    "typecated": true,
//    "typcaedgenre": [horror, comedy]
//    "numberOfTypecastedMovies": 3
//}
//"""