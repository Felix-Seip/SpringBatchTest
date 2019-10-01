package com.example.demo;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class MyChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        System.out.println("Before Chunk");
    }

    @Override
    public void afterChunk(ChunkContext chunkContext) {
        System.out.println("After Chunk");
    }

    @Override
    public void afterChunkError(ChunkContext chunkContext) {
        System.out.println("After Chunk Error");
    }
}
