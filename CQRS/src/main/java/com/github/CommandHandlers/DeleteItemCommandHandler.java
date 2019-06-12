package com.github.CommandHandlers;

import com.github.Commands.DeleteItemCommand;
import com.github.Domain.DiaryItem;
import com.github.Storage.IRepository;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:53 2019/6/10
 */
public class DeleteItemCommandHandler implements ICommandHandler<DeleteItemCommand> {

    private IRepository<DiaryItem> repository;

    public DeleteItemCommandHandler(IRepository<DiaryItem> repository) {
        this.repository = repository;
    }

    @Override
    public void execute(DeleteItemCommand command) {
        DiaryItem item = repository.getById(command.id);

        item.delete();
        repository.save(item, item.version);
    }
}
