package com.tuportfolio.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuportfolio.portfolio.models.Drawing;
import com.tuportfolio.portfolio.repositories.DrawingRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DrawingService {
    @Autowired
    private DrawingRepository drawingRepository;

    public List<Drawing> getAllDrawings() {
        return drawingRepository.findAll();
    }

    public Optional<Drawing> getDrawingById(Long id) {
        return drawingRepository.findById(id);
    }

    public Drawing saveDrawing(Drawing drawing) {
        return drawingRepository.save(drawing);
    }

    public void deleteDrawing(Long id) {
        drawingRepository.deleteById(id);
    }
}
