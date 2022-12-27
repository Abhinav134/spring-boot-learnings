package io.springbootlearnings.abhinav.data.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController 
{
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) 
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic t)
	{
		topicService.addTopic(t);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/topics")
	public void updateTopic(@RequestBody Topic t)
	{
		topicService.updateTopic(t);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics")
	public void deleteTopic(@RequestBody Topic t)
	{
		topicService.deleteTopic(t);
	}
}