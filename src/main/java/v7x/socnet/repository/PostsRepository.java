package v7x.socnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v7x.socnet.model.Posts;

import javax.transaction.Transactional;

@Transactional
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
