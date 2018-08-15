
package ro.stefanini.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.stefanini.dataOperation.QuestionDAO;
import ro.stefanini.dataOperation.UserDAO;
import ro.stefanini.data.Question;
import ro.stefanini.data.User;

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
		mav.addObject("questions", questions);
		return mav;
	}

}
