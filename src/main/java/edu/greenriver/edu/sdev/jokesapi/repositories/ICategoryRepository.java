package edu.greenriver.edu.sdev.jokesapi.repositories;

import edu.greenriver.edu.sdev.jokesapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>
{
}
