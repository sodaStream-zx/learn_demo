package pri.zxx.shiro.shirocore;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-05-28-20:28
 */
@Mapper
public interface FeedBackMapper {
    //查询所有标签
    @Select(value = " select " +
            "id,feedback_info," +
            "user_id," +
            "feedback_label," +
            "create_time," +
            "source," +
            "version" +
            " from t_user_feedback")
    @Results(id = "feedBack", value = {@Result(property = "id", column = "id"),
            @Result(property = "feedbackInfo", column = "feedback_info"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "feedbackLabel", column = "feedback_label"),
            @Result(property = "createTime", column = "create_time")
    })
    List<FeedBack> listOfFeedBacks();

    //查询指定时间段标签
    @Select(value = "<script> " +
            " select " +
            "id," +
            "feedback_info," +
            "user_id," +
            "feedback_label," +
            "create_time," +
            "source," +
            "version" +
            " from " +
            " t_user_feedback " +
            " <trim prefix='where' suffixOverrides=' AND |OR '>" +
            "<if test='st !=null '> " + " create_time <![CDATA[ >= ]]> #{st}" + " </if> " +
            "<if test='et !=null '> " + "AND  create_time <![CDATA[ <= ]]> #{et} " + " </if> " +
            "<if test='source !=null '> " + "AND  source = #{source} " + "</if> " +
            "<if test='version !=null '> " + "AND  version = #{version} " + "</if> " +
            " </trim> " +
            " </script> ")
    @ResultMap(value = "feedBack")
    List<FeedBack> listOfFeedBacksByConditions(@Param(value = "st") String st,
                                               @Param(value = "et") String et,
                                               @Param(value = "source") String source,
                                               @Param(value = "version") String version);

    //查询指定时间段标签
    @Select(value = " select " +
            "id," +
            "feedback_info," +
            "user_id," +
            "feedback_label," +
            "create_time," +
            "source," +
            "version" +
            " from " +
            " t_user_feedback where " +
            " feedback_label like CONCAT('%',#{piece},'%')")
    @ResultMap(value = "feedBack")
    List<FeedBack> listOfFeedBacksByPiece(@Param(value = "piece") String piece);
}
