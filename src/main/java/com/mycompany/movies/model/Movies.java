/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movies.model;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.util.ArrayList;

/**
 *
 * @author sony3
 */
public class Movies {
    
    //TMDB API Connection
    private static final TmdbApi CONNECTION = new TmdbApi("api-key");
    //Langauage 
    private static final String LANGUAGE = "en-US";
    
    //GET movies: Return the list of currently playing movies
    public ArrayList<MovieDb> getMovies(){
        TmdbMovies movies = new TmdbMovies(CONNECTION);
        MovieResultsPage result = movies.getNowPlayingMovies(LANGUAGE, 1, "");
        
        return (ArrayList<MovieDb>) result.getResults();
    }
    
   //Get Videos: Loading the trailing videos, return the list of vidoes
   public  ArrayList<Video> getVideos(int movieId){
        TmdbMovies movies = new TmdbMovies(CONNECTION);
        return (ArrayList<Video>) movies.getVideos(movieId, LANGUAGE);
    }
}
