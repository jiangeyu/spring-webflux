package com.github.CommandHandlers;

import com.github.Commands.ChangeItemCommand;
import com.github.Domain.DiaryItem;
import com.github.Storage.IRepository;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:52 2019/6/10
 */
public class ChangeItemCommandHandler implements ICommandHandler<ChangeItemCommand> {

    private IRepository<DiaryItem> repository;

    public ChangeItemCommandHandler(IRepository<DiaryItem> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(ChangeItemCommand command) {

        DiaryItem aggregate = repository.getById(command.getId());

        aggregate.setTitle(command.title);
        aggregate.setDescription(command.description);
        aggregate.setFrom(command.getFrom());
        aggregate.setTo(command.getTo());

        repository.save(aggregate, command.version);
    }
}
