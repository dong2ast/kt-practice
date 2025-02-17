package com.demo.kt.domain.code.repository;

import com.demo.kt.domain.code.model.CodeDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeDetailRepository extends JpaRepository<CodeDetail, String> {

    List<CodeDetail> findAllByGroupId(String groupId);
}
