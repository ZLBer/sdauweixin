package weixin.msg.Util;

/**
 * Created by C on 2017/5/4.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;



public class ContentDao {

    public void add(Content content) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into enter_info (content)  values (?) ";
            ps = conn.prepareStatement(sql);

            ps.setString(1, content.getContent());

            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

}
