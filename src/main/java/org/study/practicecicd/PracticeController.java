package org.study.practicecicd;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practice")
@RequiredArgsConstructor
public class PracticeController {

    private final PracticeService practiceService;

    @GetMapping("/{id}")
    public ResponseEntity<PracticeResponse> getPractice(@PathVariable long id) {
        PracticeDTO practiceDTO = practiceService.getPractice(id);
        return ResponseEntity.ok(new PracticeResponse(practiceDTO.id(), practiceDTO.name()));
    }

    @PostMapping
    public ResponseEntity<String> savePractice(@RequestParam String name) {
        PracticeDTO practiceDTO = new PracticeDTO(null, name);
        practiceService.savePractice(practiceDTO);
        int a = "c";
        return ResponseEntity.status(201).build();
    }
}
