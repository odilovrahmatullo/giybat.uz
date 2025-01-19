package giybat.uz.post.controller;

import giybat.uz.exceptionHandler.AppBadException;
import giybat.uz.post.dto.CreatePostDTO;
import giybat.uz.post.dto.FilterDTO;
import giybat.uz.post.dto.PostDTO;
import giybat.uz.post.dto.PostInfoDTO;
import giybat.uz.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@Tag(name = "Post Controller", description = "Post management")
public class PostController {
    @Autowired
    private PostService postService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/")
    @Operation(summary = "user create post", description = "Users can create posts in the buyer.")
    public ResponseEntity<?> create(@RequestBody CreatePostDTO dto) {
        PostDTO postDTO = postService.AddedPost(dto);
        return ResponseEntity.ok(postDTO);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    @Operation(summary = "Update", description = "Edit Content or photo")
    public ResponseEntity<?> update(@RequestBody CreatePostDTO dto, @PathVariable Integer id) {
        return ResponseEntity.ok(postService.update(dto, id));
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "delete", description = "In Buyer, a User can delete their own post or an ADMIN can delete all users' posts.")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.delete(id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get By Id", description = "Post get By Id")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPostId(id));
    }

    @GetMapping("/all")
    private ResponseEntity<?> pagination(@RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(postService.postAll(page - 1, size));
    }

    @PostMapping("/filter")
    @Operation(summary = "Filter", description = "filter (user:name,surname or content)")
    public ResponseEntity<?> filter(@RequestBody FilterDTO dto,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        Page<PostInfoDTO> filter = postService.filter(dto, page - 1, size);
        return ResponseEntity.ok(filter);
    }


    @ExceptionHandler({AppBadException.class, IllegalArgumentException.class})
    public ResponseEntity<?> handle(AppBadException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
