package com.training.christian.pocketlink;

import java.util.List;

public interface iLinkDataBase {
    List<Link> getLinks();

    void create(Link link);
}
