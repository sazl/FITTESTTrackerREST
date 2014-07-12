repos = ['Activity',
        'ActivityRole',
        'ActivityType',
        'AuditRecord',
        'ConfirmedType',
        'Country',
        'Event',
        'Language',
        'OperationType',
        'ProfileType',
        'Staff',
        'StaffRole',
        'StaffType']

repo_template = "package org.wfp.fittest.repository; import org.wfp.fittest.entity.{name}; public interface {name}Repository extends CrudRepository<{name}, Long>, {name}RepositoryCustom {{}}"

repo_custom_template = "package org.wfp.fittest.repository.custom; public interface {name}RepositoryCustom {{}}"

repo_impl_template = "package org.wfp.fittest.repository.impl; public class {name}RepositoryImpl implements {name}RepositoryCustom {{}}"


for repo in repos:
    fname_repo = repo + 'Repository.java'
    fname_repo_impl = 'impl/' + repo + 'RepositoryImpl.java'
    fname_repo_custom = 'custom/' + repo + 'RepositoryCustom.java'
    print(repo_template.format(name=repo), file=open(fname_repo, 'w'))
    print(repo_impl_template.format(name=repo), file=open(fname_repo_impl, 'w'))
    print(repo_custom_template.format(name=repo), file=open(fname_repo_custom, 'w'))