package org.study.practicecicd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PracticeService {

    private final PracticeRepository practiceRepository;

    public PracticeDTO getPractice(final long id) {
        PracticeEntity practiceEntity = practiceRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ERROR")
        );

        return new PracticeDTO(practiceEntity.getId(), practiceEntity.getName());
    }

    public void savePractice(final PracticeDTO practiceDTO) {
        practiceRepository.save(new PracticeEntity(practiceDTO.id(), practiceDTO.name()));
    }
}
