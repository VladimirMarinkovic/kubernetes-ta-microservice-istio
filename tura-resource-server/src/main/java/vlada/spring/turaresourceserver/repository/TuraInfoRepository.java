package vlada.spring.turaresourceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlada.spring.turaresourceserver.model.TuraInfo;

public interface TuraInfoRepository extends JpaRepository<TuraInfo, Long> {
}
