package pl.zajecia3.filmy.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zajecia3.filmy.entity.VideoCassete;
import pl.zajecia3.filmy.entity.VideoCasseteRepo;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {
    private VideoCasseteRepo videoCasseteRepo;

    @Autowired
    public VideoCassetteManager(VideoCasseteRepo videoCasseteRepo) {
        this.videoCasseteRepo = videoCasseteRepo;
    }
    public Optional<VideoCassete> findAllById(Long id){
        return videoCasseteRepo.findById(id);
    }
    public Iterable<VideoCassete> findAll(){
        return videoCasseteRepo.findAll();
    }
    public VideoCassete save(VideoCassete videoCassete){
        return  videoCasseteRepo.save(videoCassete);
    }
    public void delete(Long id){
        videoCasseteRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
       save(new VideoCassete(1L, "Tytuł1", LocalDate.of(1999, 12, 3)));
        save(new VideoCassete(2L, "Tytuł2", LocalDate.of(2015, 2, 4)));
    }
}
