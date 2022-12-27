package io.springbootlearnings.abhinav.data.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
	}
	
	public Course getCourse(String id)
	{
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course c)
	{
		courseRepository.save(c);
	}
	
	public void updateCourse(Course c)
	{
		courseRepository.save(c);
	}
	
	public void deleteCourse(Course c)
	{
		courseRepository.delete(c);
	}
}