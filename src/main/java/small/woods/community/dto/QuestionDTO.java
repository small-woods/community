package small.woods.community.dto;

import lombok.Data;
import small.woods.community.model.User;

/**
 * 该类的数据用于网络中的传输，绑定user表和question表
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
