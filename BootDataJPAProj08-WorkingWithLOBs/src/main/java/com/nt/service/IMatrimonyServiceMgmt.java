//IMatrimonyServiceMgmt.java(13/14.03.2025)
package com.nt.service;

import java.util.Optional;

import com.nt.entity.MarriageSeeker;

public interface IMatrimonyServiceMgmt {
    public String registerMarriageSeeker(MarriageSeeker seeker);
    public Optional<MarriageSeeker> searchSeekerById(Integer id);
}
