package pl.zajecia3.filmy.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia3.filmy.entity.VideoCassete;

@Repository
public interface VideoCasseteRepo extends CrudRepository<VideoCassete,Long> {

}
