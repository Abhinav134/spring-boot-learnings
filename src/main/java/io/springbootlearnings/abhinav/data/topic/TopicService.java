package io.springbootlearnings.abhinav.data.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic t)
	{
		//topics.add(t);
		topicRepository.save(t);
	}
	
	public void updateTopic(Topic topic)
	{
		topicRepository.save(topic);
	}
	
	public void deleteTopic(Topic topic)
	{
		topicRepository.delete(topic);
	}
}