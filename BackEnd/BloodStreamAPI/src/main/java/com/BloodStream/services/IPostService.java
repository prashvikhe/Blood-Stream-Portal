package com.BloodStream.services;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.BloodStream.dto.PostAddDto;
import com.BloodStream.enums.Antigens;
import com.BloodStream.enums.BloodTypes;
import com.BloodStream.enums.PostCategory;
import com.BloodStream.pojos.Post;
import com.BloodStream.pojos.UserAddress;

public interface IPostService {

	Post addPost(Post post, Long userId);
	
	boolean deletePostById(Long id);
	
	List<Post> findByTypeAndAntigen(BloodTypes type,Antigens antigen);
	
	List<Post> findByPostCategory(PostCategory postcategory);
	
	List<Post> findByTypeAndSort(BloodTypes type, Antigens antigen,Sort sort);
	
	Post findById(Long id);
	
	List<Post> getAllPostByUser(Long userID);
	
	List<Post> getAllPosts();
	 
	List<PostAddDto> getAllPosts2();
	List<UserAddress> getAllPosts3();

	UserAddress findAddressById(Long id);

}
