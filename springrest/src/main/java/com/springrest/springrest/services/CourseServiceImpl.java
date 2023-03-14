package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
			
		list = new ArrayList<>();
		list.add(new Course(145,"Java Course", "this course contains basic in java programming."));
		list.add(new Course(143,"Spring boot Course", "this course teaches REST API using spring boot framework."));
		
		
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		
		for(Course course : list) {
			if(course.getId() == courseId) {
				c= course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(long courseId, Course course) {
		Course c = null;
		
		for(Course course1: list) {
			if(course1.getId() == courseId) {
				
				c= course;
				break;
			}
		}
		list.remove(c);
		list.add(course);
		return course;
	}
	
	

	@Override
	public void deleteCourse(long courseId) {
			
		
		for(Course course: list) {
			if(course.getId() == courseId) {
				list.remove(course);
				break;
			}
		}
	}
	
	
	
	

}
