package kg.Lessons.Lessona.repository;
import kg.Lessons.Lessona.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface HelloRepository extends JpaRepository<Message,Integer> {
    @Query("select h from Message h where id>:count")
    List<Message> getAllOld(@Param("count")Integer count);
    }
