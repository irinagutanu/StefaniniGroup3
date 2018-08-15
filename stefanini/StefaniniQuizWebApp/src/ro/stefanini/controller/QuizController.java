
package ro.stefanini.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.stefanini.data.Question;
import ro.stefanini.data.QuestionsList;
import ro.stefanini.dataOperation.QuestionDAO;

@Controller
public class QuizController {

	@Autowired
	private QuestionDAO questionDao;

	@RequestMapping(value = "/showQuiz", method = RequestMethod.GET)
	public ModelAndView showQuiz(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Show quiz");
		ModelAndView mav = new ModelAndView("quiz");
		List<Question> questions = questionDao.getQuestions();
		Collections.shuffle(questions);
		QuestionsList questionsList = new QuestionsList();
		questionsList.setQuestions(questions);
		mav.addObject("questionsList", questionsList);
		System.out.println(questionsList.getQuestions().size());
		return mav;
	}
	
	@RequestMapping(value = "/showResult", method = RequestMethod.POST)
	public String showResult(@ModelAttribute("question") QuestionsList questionsList, Model model) {
		System.out.println(questionsList.getQuestions().get(0).getAnswers().get(0).getAnswer());
		System.out.println(questionsList.getQuestions().get(0).getAnswers().get(0).getValue());
		System.out.println(questionsList.getQuestions().get(0).getAnswers().get(0).getAnswer());
		System.out.println(questionsList.getQuestions().get(0).getAnswers().get(0).getValue());
		return "result";
	}
}
