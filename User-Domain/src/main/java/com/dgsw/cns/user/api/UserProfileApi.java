package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberImageVO;

/**
 *
 */
public interface UserProfileApi {

    MemberImageVO getImage(Long userId);

    void setImage(MemberImageVO image);

}
