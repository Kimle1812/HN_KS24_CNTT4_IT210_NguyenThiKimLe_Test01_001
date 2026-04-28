package org.example.artworkmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.artworkmanagement.model.Artwork;
import org.example.artworkmanagement.repository.IArtworkRepository;
import org.example.artworkmanagement.service.IArtworkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtworkServiceImpl implements IArtworkService {

    private final IArtworkRepository artworkRepository;

    @Override
    public List<Artwork> getAllArtwork() {
        return artworkRepository.findAll();
    }
    @Override
    public  void save (Artwork artwork){
        artworkRepository.save(artwork);
    }
    @Override
    public Artwork findById(Long id){
        return artworkRepository.findById(id).orElse(null);
    }
    @Override
    public void delete (Long id){
        artworkRepository.deleteById(id);
    }
}
