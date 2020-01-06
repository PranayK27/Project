package com.poc.aim.repository;

import com.poc.aim.model.Bovine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BovineRepository extends JpaRepository<Bovine, Long>{
	//List<Bovine> search(long id);
	@Query(value="SELECT * FROM bovine", nativeQuery=true)
			Optional<List<Bovine>> getBovineById(long id);
//	@Query(value="INSERT INTO TABLE bovine", nativeQuery=true)
	
	
}
