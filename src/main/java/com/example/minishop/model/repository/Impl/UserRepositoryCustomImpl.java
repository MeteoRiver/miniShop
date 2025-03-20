package com.example.minishop.model.repository.Impl;

import com.example.minishop.model.domain.UserModel;
import com.example.minishop.model.entity.mysql.User;
import com.example.minishop.model.repository.Custom.UserRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    QUser user = Quser.user;

    @Override
    public Page<UserModel> findAllUser(Pageable pageable){
        var userIds = jpaQueryFactory
                .select(user.id)
                .from(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        List<UserModel> userModel = userIds.isEmpty() ? List.of() :
                jpaQueryFactory
                        .select(Projections.constructor(
                                UserModel.class,
                                user.id,
                                user.email,
                                user.name,
                                user.phone,
                                user.role,
                                user.createdAt,
                                user.updatedAt
                        ))
                        .from(user)
                        .where(user.id.in(userIds))
                        .fetch();
        return new PageImpl<>(userModel, pageable, userIds.size());
    }
}
