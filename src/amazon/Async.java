package amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Async {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");

        System.out.println(future.get());
    }
}
