package org.example.artworkmanagement.repository;

import org.example.artworkmanagement.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtworkRepository extends JpaRepository<Artwork, Long> {

}
