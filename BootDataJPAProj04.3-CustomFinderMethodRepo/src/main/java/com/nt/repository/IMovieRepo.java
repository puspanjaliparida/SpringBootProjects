//IMovieRepo.java(07.03.2025)
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Movie;

public  interface IMovieRepo extends JpaRepository<Movie,Integer>{
      //Select mid,mname,year,ratings From Movie Where mname=?
	public List<Movie> findByMovNameEquals(String name);
	//Select mid,mname,year,ratings From Movie Where  mname=?
    public List<Movie> findByMovNameIs(String name);
    //Select mid,mname,year,ratings From Movie Where mname=?
    public List<Movie> findByMovName(String name);
    
    //Select mid,mname,year,ratings From Movie Where  mname Like 'J%'
    public Iterable<Movie> findByMovNameStartingWith(String initChars);
    
    //Select mid,mname,year,ratings From Movie Where mname Like '%I'
    public Iterable<Movie> findByMovNameEndingWith(String lastChars);
    
    //Select mid,mname,year,ratings From Movie Where mname Like '%hub%'
    public Iterable<Movie> findByMovNameContaining(String Chars);
    
    //Select mid,mname,year,ratings From Movie Where mname Like '%str%'
    public Iterable<Movie> findByMovNameEqualsIgnoreCase(String name);
    
    //Select mid,mname,year,ratings From Movie Where mname Like '%For%'
    public Iterable<Movie> findByMovNameContainingIgnoreCase(String chars);
}
