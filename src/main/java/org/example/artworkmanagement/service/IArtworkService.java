package org.example.artworkmanagement.service;

import org.example.artworkmanagement.model.Artwork;

import java.util.List;

public interface IArtworkService {
    List<Artwork> getAllArtwork();
    void save(Artwork artwork);
    Artwork findById(Long id);
    void delete (Long id);
}
