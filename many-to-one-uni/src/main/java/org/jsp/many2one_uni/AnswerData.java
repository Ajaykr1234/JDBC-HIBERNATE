package org.jsp.many2one_uni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String answerBy;

	@Column(nullable = false)
	private String answer;

	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionData Question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswerBy() {
		return answerBy;
	}

	public void setAnswerBy(String answerBy) {
		this.answerBy = answerBy;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionData getQuestion() {
		return Question;
	}

	public void setQuestion(QuestionData question) {
		Question = question;
	}

	@Override
	public String toString() {
		return "AnswerData [id=" + id + ", answerBy=" + answerBy + ", answer=" + answer + "]";
	}

}
