package com.swb.apirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.swb.apirest.models.MedicaoAgua;

public interface MedicaoRepository extends JpaRepository<MedicaoAgua, Long> {
	
	MedicaoAgua findById(long id);
}
