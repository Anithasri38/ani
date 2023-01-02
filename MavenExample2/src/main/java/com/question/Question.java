package com.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {
	private String questionId;
	private String question;
	private List<String> answers1;
	private Set<String> answers2;
	private Map<Integer,String> answers3;
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Set<String> getAnswers2() {
		return answers2;
	}
	public void setAnswers2(Set<String> answers2) {
		this.answers2 = answers2;
	}
	
	public List<String> getAnswers1() {
		return answers1;
	}
	public void setAnswers1(List<String> answers1) {
		this.answers1 = answers1;
	}
	public Map<Integer, String> getAnswers3() {
		return answers3;
	}
	public void setAnswers3(Map<Integer, String> answers3) {
		this.answers3 = answers3;
	}
	
	public void displayList()
	{
		System.out.println("QuestionId="+getQuestionId());
		System.out.println("Question name="+getQuestion());
		System.out.println("Answers:"+getAnswers1());
		/*for(String answer:answers)
		{
			System.out.println(answer.getAnswers());
		}*/
	}
	public void displaySet()
	{  
		System.out.println("QuestionId="+getQuestionId());
		System.out.println("Question name="+getQuestion());
		System.out.println("Answers:"+getAnswers2());
	}
	public void displayMap()
	{
		System.out.println("QuestionId="+getQuestionId());
		System.out.println("Question name="+getQuestion());
		System.out.println("Answers:"+getAnswers3());
	}

}
