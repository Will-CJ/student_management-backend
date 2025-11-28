package com.example.student_service.presentation.controller;

import com.example.student_service.domain.model.Student;
import com.example.student_service.presentation.dto.request.*;
import com.example.student_service.presentation.dto.response.*;
import com.example.student_service.application.usecase.*;
import com.example.student_service.application.command.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {


    private final CreateStudentUseCase createUC;
    private final ListAllStudentsUseCase listUC;
    private final UpdateStudentUseCase updateUC;
    private final DeleteStudentUseCase deleteUC;


    public StudentController(CreateStudentUseCase createUC, ListAllStudentsUseCase listUC, UpdateStudentUseCase updateUC, DeleteStudentUseCase deleteUC) {
        this.createUC = createUC;
        this.listUC = listUC;
        this.updateUC = updateUC;
        this.deleteUC = deleteUC;
    }


    @PostMapping
    public ResponseEntity<CreateStudentResponse> create(@Valid @RequestBody CreateStudentRequestDto dto) {
        String id = createUC.execute(new CreateStudentCommand(dto.firstName(), dto.lastName(), dto.birthDate()));
        return ResponseEntity.ok(new CreateStudentResponse(id));
    }


    @GetMapping
    public List<StudentResponseDto> list() {
        return listUC.execute();
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> update(@Valid @RequestBody UpdateStudentRequestDto dto) {
        UpdateStudentCommand cmd = new UpdateStudentCommand(dto.id(), dto.firstName(), dto.lastName(), dto.birthDate());
        Student updated = updateUC.execute(cmd);
        return ResponseEntity.ok(new UpdateStudentResponseDto(
                updated.getId(),
                updated.getFirstName(),
                updated.getLastName(),
                updated.getBirthDate().toString()
        ));
    }

    @DeleteMapping
    public ResponseEntity<DeleteStudentResponseDto> delete(@Valid @RequestBody DeleteStudentRequestDto dto) {
        deleteUC.execute(dto.id());
        return ResponseEntity.ok(new DeleteStudentResponseDto(dto.id(), "Student deleted successfully"));
    }
}
