package giybat.uz.post.controller;

import giybat.uz.exceptionHandler.AppBadException;
import giybat.uz.post.dto.CreatePostDTO;
import giybat.uz.post.dto.PostDTO;
import giybat.uz.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreatePostDTO dto){
        PostDTO postDTO = postService.AddedPost(dto);
        return ResponseEntity.ok(postDTO);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CreatePostDTO dto, @PathVariable Integer id){
        return ResponseEntity.ok(postService.update(dto,id));
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok(postService.delete(id));
    }

    @ExceptionHandler({AppBadException.class, IllegalArgumentException.class})
    public ResponseEntity<?> handle(AppBadException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }



}
