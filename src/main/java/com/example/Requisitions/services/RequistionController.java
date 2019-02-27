package com.example.Requisitions.services;

import com.example.Requisitions.Requisition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
public class RequistionController {

    @GetMapping("/Requisition/{id}")
    Mono<Requisition> eventById(@PathVariable Long id) {
		return Mono.just(new Requisition(id, new Date() ));
	}


	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/Requisition")
	Flux<Requisition> Requisition() {

		Flux<Requisition> eventFlux = Flux.fromStream(Stream.generate(
				() -> new Requisition(System.currentTimeMillis(), new Date())));

		Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));

		return Flux.zip(eventFlux, durationFlux)
				.map(Tuple2::getT1);
	}

}
