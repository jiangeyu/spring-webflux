package com.github.CommandHandlers;

import com.github.Commands.CreateItemCommand;
import com.github.Domain.DiaryItem;
import com.github.Storage.IRepository;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:53 2019/6/10
 */
public class CreateItemCommandHandler implements ICommandHandler<CreateItemCommand> {

    private IRepository<DiaryItem> repository;

    public CreateItemCommandHandler(IRepository<DiaryItem> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(CreateItemCommand command) {

        DiaryItem item = DiaryItem.builder()
                .description(command.description)
                .from(command.from)
                .title(command.title)
                .to(command.to)
                .build();

        item.version = -1;
        repository.save(item, item.version);

    }
}
