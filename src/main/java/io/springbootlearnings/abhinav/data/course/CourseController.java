package io.springbootlearnings.abhinav.data.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springbootlearnings.abhinav.data.topic.Topic;

@RestController
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/course")
	public List<Course> getAllCourses(@PathVariable String topicId)
	{
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/course/{id}")
	public Course getCourse(@PathVariable String id) 
	{
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
	public void addCourse(@RequestBody Course c,@PathVariable String topicId)
	{
		c.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/course")
	public void updateCourse(@RequestBody Course c,@PathVariable String topicId)
	{
		c.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(c);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/course")
	public void deleteCourse(@RequestBody Course c)
	{
		courseService.deleteCourse(c);
	}
}