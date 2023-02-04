package dive.dev.thirdy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dive.dev.thirdy.models.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

	

}
