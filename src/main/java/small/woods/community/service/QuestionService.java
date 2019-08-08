package small.woods.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import small.woods.community.dto.QuestionDTO;
import small.woods.community.mapper.QuestionMapper;
import small.woods.community.mapper.UserMapper;
import small.woods.community.model.Question;
import small.woods.community.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    public List<QuestionDTO> List() {
        List<Question> questions = questionMapper.List();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question :questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
