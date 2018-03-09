package project.eloisance.com.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import project.eloisance.com.domain.User;
import project.eloisance.com.domain.executor.PostExecutionThread;
import project.eloisance.com.domain.executor.ThreadExecutor;
import project.eloisance.com.domain.repository.UserRepository;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetUserList extends UseCase<List<User>, Void> {

  private final UserRepository userRepository;

  @Inject
  GetUserList(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.userRepository = userRepository;
  }

  @Override
  Observable<List<User>> buildUseCaseObservable(Void unused) {
    return this.userRepository.users();
  }
}
